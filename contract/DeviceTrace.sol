// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract DeviceTrace {
    struct FlowRecord {
        string deviceCode;
        string eventType;
        string dataHash;
        string operator;
        uint256 timestamp;
        string txRef;
    }

    mapping(string => FlowRecord[]) private flowsByDevice;
    mapping(string => string) private latestStatusByDevice;

    event DeviceRegistered(string indexed deviceCode, string eventType, string dataHash, string operator, uint256 timestamp);
    event FlowAdded(string indexed deviceCode, string eventType, string dataHash, string operator, uint256 timestamp);

    function registerDevice(
        string calldata deviceCode,
        string calldata eventType,
        string calldata dataHash,
        string calldata operator,
        string calldata txRef
    ) external {
        require(bytes(deviceCode).length > 0, "deviceCode required");
        require(bytes(dataHash).length > 0, "dataHash required");
        FlowRecord memory rec = FlowRecord(deviceCode, eventType, dataHash, operator, block.timestamp, txRef);
        flowsByDevice[deviceCode].push(rec);
        latestStatusByDevice[deviceCode] = eventType;
        emit DeviceRegistered(deviceCode, eventType, dataHash, operator, block.timestamp);
    }

    function addFlowRecord(
        string calldata deviceCode,
        string calldata eventType,
        string calldata dataHash,
        string calldata operator,
        string calldata txRef
    ) external {
        require(bytes(deviceCode).length > 0, "deviceCode required");
        FlowRecord memory rec = FlowRecord(deviceCode, eventType, dataHash, operator, block.timestamp, txRef);
        flowsByDevice[deviceCode].push(rec);
        latestStatusByDevice[deviceCode] = eventType;
        emit FlowAdded(deviceCode, eventType, dataHash, operator, block.timestamp);
    }

    function getDeviceFlowCount(string calldata deviceCode) external view returns (uint256) {
        return flowsByDevice[deviceCode].length;
    }

    function getDeviceFlowByIndex(string calldata deviceCode, uint256 index)
        external
        view
        returns (string memory eventType, string memory dataHash, string memory operator, uint256 timestamp, string memory txRef)
    {
        require(index < flowsByDevice[deviceCode].length, "index out of range");
        FlowRecord memory rec = flowsByDevice[deviceCode][index];
        return (rec.eventType, rec.dataHash, rec.operator, rec.timestamp, rec.txRef);
    }

    function getLatestDeviceStatus(string calldata deviceCode) external view returns (string memory) {
        return latestStatusByDevice[deviceCode];
    }
}
