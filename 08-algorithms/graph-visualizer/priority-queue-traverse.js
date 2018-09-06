'use strict';

function dijkstra() {
  const startCell = world.board.getCell(world.config.start.row, world.config.start.col);

  startCell.distFromStart = 0;
  startCell.parent = undefined;
  const cellsPriorityQueue = [startCell];

  cellsPriorityQueue.remove = () => {
    cellsPriorityQueue.sort((a, b) => a.distFromStart - b.distFromStart);
    return cellsPriorityQueue.shift();
  }

  traversePriorityQueue(cellsPriorityQueue);
}

function aStar() {
  precomputeEstimatedDistToEnd();

  const startCell = world.board.getCell(world.config.start.row, world.config.start.col);

  startCell.distFromStart = 0;
  startCell.parent = undefined;
  const cellsPriorityQueue = [startCell];

  cellsPriorityQueue.remove = () => {
    cellsPriorityQueue.sort((a, b) => (a.distFromStart + a.estimatedDistToEnd) -
     (b.distFromStart + b.estimatedDistToEnd));
    return cellsPriorityQueue.shift();
  }

  traversePriorityQueue(cellsPriorityQueue);
}

function precomputeEstimatedDistToEnd() {

  const end = world.board.getCell(world.config.end.row, world.config.end.col);
  for(let i = 0; i< world.board.rows; i++) {
    for(let j = 0; j < world.board.cols; j++) {
      const cell = world.board.getCell(i,j);
      cell.estimatedDistToEnd = Math.hypot(cell.row - end.row, cell.col - end.col); 
    }
  }
}

function traversePriorityQueue(cells) {
  if (cells.length === 0 || world.board.endReached) {
    return;
  }
  const cell = cells.remove();

  console.log(`Traversing ${cell.row} ${cell.col}`);
  cell.status = CellStatus.CLOSED;

  if (cell.row == world.config.end.row && cell.col === world.config.end.col) {
    console.log("end reached");
    world.board.endReached = true;
    colorFoundWay();
  }

  getNeighbors(cell).filter(n =>
    n.status === CellStatus.UNREACHED ||
    n.status === CellStatus.OPEN)
    .forEach(n => {
      if (n.status === CellStatus.UNREACHED) {
        n.status = CellStatus.OPEN;
        cells.push(n);
        n.parent = cell;
        n.distFromStart = cell.distFromStart + 1;
      }

      if (n.distFromStart > cell.distFromStart + 1) {
        n.distFromStart = cell.distFromStart + 1;
        n.parent = cell;
      }
    });

  setTimeout(() => {
     traversePriorityQueue(cells);
  }, world.config.stepWait);
}

