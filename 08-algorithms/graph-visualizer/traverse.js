'use strict';

function dfs() {
  const startCell = world.board.getCell(world.config.start.row, world.config.start.col);
  startCell.distFromStart = 0;
  startCell.parent = undefined;
  const cellsStack = [startCell];

  traverseDfs(cellsStack);
}

function bfs() {
  const startCell = world.board.getCell(world.config.start.row, world.config.start.col);
  startCell.distFromStart = 0;
  startCell.parent = undefined;
  const cellsQueue = [startCell];

  traverseBfs(cellsQueue);
}

function traverseBfs(cells) {
  if (cells.length === 0 || world.board.endReached) {
    return;
  }
  const cell = cells.shift();

  console.log(`Traversing ${cell.row} ${cell.col}`);
  cell.status = CellStatus.OPEN;

  if (cell.row == world.config.end.row && cell.col === world.config.end.col) {
    console.log("end reached");
    world.board.endReached = true;
    colorFoundWay();
  }

  const neighbors = getNeighbors(cell);

  for (let i = 0; i < neighbors.length; i++) {
    const neighbor = neighbors[i];
    if (neighbor.status === CellStatus.UNREACHED) {
      cells.push(neighbor);
      neighbor.status = CellStatus.OPEN;
      neighbor.parent = cell;
    }
  }

  setTimeout(() => {
    traverseBfs(cells);
  }, world.config.stepWait);

  cell.status = CellStatus.CLOSED;
}

function traverseDfs(cells) {
  if (cells.length === 0 || world.board.endReached) {
    return;
  }
  const cell = cells.pop();

  console.log(`Traversing ${cell.row} ${cell.col}`);
  cell.status = CellStatus.OPEN;

  if (cell.row == world.config.end.row && cell.col === world.config.end.col) {
    console.log("end reached");
    world.board.endReached = true;
    colorFoundWay();
  }

  const neighbors = getNeighbors(cell);

  for (let i = 0; i < neighbors.length; i++) {
    const neighbor = neighbors[i];
    if (neighbor.status === CellStatus.UNREACHED) {
      cells.push(neighbor);
      neighbor.status = CellStatus.OPEN;
      neighbor.parent = cell;
    }
  }

  setTimeout(() => {
    traverseDfs(cells);
  }, world.config.stepWait);

  cell.status = CellStatus.CLOSED;
}