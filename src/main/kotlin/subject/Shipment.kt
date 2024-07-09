package subject
import subject.update.Update

class Shipment(
    val id: String,
): Subject() {
    val notes: MutableList<String> = mutableListOf()
    val updateHistory: MutableList<ShippingUpdate> = mutableListOf()
    val expectedDeliveryDateTimestampHistory: MutableList<Long> = mutableListOf()
    val locationHistory: MutableList<String> = mutableListOf()

    fun addUpdate(update: Update) {
        addNote(update.getNote())
        addLocation(update.getLocation())
        addExpectedDeliveryDateTimestamp(update.getExpectedDeliveryDateTimestamp())

        val previousState = if (updateHistory.size == 0) { "" } else { updateHistory[updateHistory.size-1].toString() }

        val shippingUpdate = ShippingUpdate(previousState, update.type, update.timestampOfUpdate)
        updateHistory.add(shippingUpdate)
    }

    private fun addNote(note: String?) {
        if (note != null) {
            notes.add(note)
        }
    }

    private fun addLocation(location: String?) {
        if (location != null) {
            locationHistory.add(location)
        }
    }

    private fun addExpectedDeliveryDateTimestamp(expectedDeliveryDateTimestamp: Long?) {
        if (expectedDeliveryDateTimestamp != null) {
            expectedDeliveryDateTimestampHistory.add(expectedDeliveryDateTimestamp)
        }
    }

}