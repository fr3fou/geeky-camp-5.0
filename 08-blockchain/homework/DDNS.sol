pragma solidity ^0.4.0;
contract DDNS {
    struct Domain {
        uint ip;
        address owner;
        bool isBought;
    }
    
    address contractOwner;
    
    constructor() public {
        contractOwner = msg.sender;
    }

    mapping(string => Domain) domains;
     
    function buyDomain(string domain) public payable { //the 'payable' modifier is needed in order to receive ETH. Read the docs for further info.
        require(domains[domain].isBought == false && msg.value == 1 ether && msg.sender.balance - 1 ether >= 0);
        domains[domain] = Domain(0, msg.sender, true);
    }
    
    function setIP(string domain, uint ip) public {
        require(domains[domain].isBought == true && domains[domain].owner == msg.sender);
        domains[domain].ip = ip;
    }
    
    function getIP(string domain) public view returns (uint) {
        require(domains[domain].isBought == true && domains[domain].owner == msg.sender);
        return domains[domain].ip;
    }
    
    function withdraw(uint value) public {
        require(msg.sender == contractOwner);
        contractOwner.transfer(value * (10**18));
    }
    
}
