package subject.update

import logger.Logger.Level
import manager.LoggerManager.logger

class Location(
    type: String,
    shipmentId: String,
    timeStampOfUpdate: Long,
    otherInfo: String?
) : Update(type, shipmentId, timeStampOfUpdate, otherInfo) {

    init {
        // TODO check if valid data
        logger.log(Level.INFO, Thread.currentThread().threadId().toString(), "Created Location update for shipment: $shipmentId")
    }

    override fun getLocation(): String? {
        val location = otherInfo
        logger.log(Level.INFO, Thread.currentThread().threadId().toString(), "Getting location for Location update (shipment: $shipmentId): $location")
        return location
    }

    override fun getNote(): String? {
        logger.log(Level.INFO, Thread.currentThread().threadId().toString(), "Getting note for Location update (shipment: $shipmentId)")
        return null
    }

    override fun getExpectedDeliveryDateTimestamp(): Long? {
        logger.log(Level.INFO, Thread.currentThread().threadId().toString(), "Getting expected delivery date timestamp for Location update (shipment: $shipmentId)")
        return null
    }
}
