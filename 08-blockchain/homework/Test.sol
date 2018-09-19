pragma solidity ^0.4.21;
contract Test {
    uint private counter = 0;
    address public owner;
    
    constructor() public {
        owner = msg.sender;
    }
    
    function inc() public {
        require(msg.sender == owner && counter + 1 > counter);
        counter++;
    }
    
    function getCounter() public view returns (uint)  {
        return counter;
    }
    
}
