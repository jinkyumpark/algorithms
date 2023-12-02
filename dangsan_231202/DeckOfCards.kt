package dangsan_231202

import java.util.*

class DeckOfCards {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val sortedDeck = deck.sorted()

        val indexQueue = LinkedList<Int>()
        for (i in deck.indices) {
            indexQueue.add(i)
        }

        val answer = IntArray(deck.size)
        for (card in sortedDeck) {
            answer[indexQueue.poll()] = card
            if (indexQueue.isNotEmpty()) {
                indexQueue.add(indexQueue.poll())
            }
        }

        return answer
    }
}
