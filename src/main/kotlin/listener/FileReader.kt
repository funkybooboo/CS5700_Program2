package listener

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import logger.Level
import logger

class FileReader(
    private val queue: Queue<String>,
    private val fileName: String,
): UpdateListener {
    override suspend fun listen() = withContext(Dispatchers.IO) {
        try {
            val file = File(fileName)
            logger.log(Level.INFO, Thread.currentThread().threadId().toString(), "Starting to read file: $fileName")
            val lines = file.readLines()
            lines.forEach { line ->
                queue.enqueue(line)
                logger.log(Level.INFO, Thread.currentThread().threadId().toString(), "Enqueued line: $line")
            }
            logger.log(Level.INFO, Thread.currentThread().threadId().toString(), "File reading completed: $fileName")
        } catch (e: Exception) {
            logger.log(Level.ERROR, Thread.currentThread().threadId().toString(), "Error reading file: $fileName - ${e.message}")
            e.printStackTrace()
        }
    }
}
