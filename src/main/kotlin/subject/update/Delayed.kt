package subject.update

import logger.Logger.Level
import manager.LoggerManager.logger

class Delayed(
    type: String,
    shipmentId: String,
    timeStampOfUpdate: Long,
    otherInfo: String?
) : Update(type, shipmentId, timeStampOfUpdate, otherInfo) {

    init {
        // TODO check if valid data
        logger.log(Level.INFO, Thread.currentThread().threadId().toString(), "Created Delayed update for shipment: $shipmentId")
    }

    override fun getLocation(): String? {
        logger.log(Level.INFO, Thread.currentThread().threadId().toString(), "Getting location for Delayed update (shipment: $shipmentId)")
        return null
    }

    override fun getNote(): String? {
        logger.log(Level.INFO, Thread.currentThread().threadId().toString(), "Getting note for Delayed update (shipment: $shipmentId)")
        return null
    }

    override fun getExpectedDeliveryDateTimestamp(): Long? {
        val timestamp = otherInfo?.toLong()
        logger.log(Level.INFO, Thread.currentThread().threadId().toString(), "Getting expected delivery date timestamp for Delayed update (shipment: $shipmentId): $timestamp")
        return timestamp
    }
}
