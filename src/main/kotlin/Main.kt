import javax.sound.midi.MidiEvent
import javax.sound.midi.MidiSystem
import javax.sound.midi.Sequence
import javax.sound.midi.ShortMessage
import kotlin.system.exitProcess

fun main() {
    val player = MyMidiPlayer()
    player.setUpPlayer(15)
}

class MyMidiPlayer {
    fun setUpPlayer(numberOfNotes: Int) = try {
        val sequencer = MidiSystem.getSequencer()
        sequencer.open()

        val sequence = Sequence(Sequence.PPQ, 4)

        val track = sequence.createTrack()

        for(i in 5..(4 * numberOfNotes + 5) step 4) {
            track.add(makeEvent(144, 1, i, 100, i))
            track.add(makeEvent(128, 1, i, 100, i + 2))
        }

        sequencer.sequence = sequence
        sequencer.tempoInBPM = 220.0F
        sequencer.start()

        while(true) {
            if(!sequencer.isRunning) {
                sequencer.close()
                exitProcess(1)
            }
        }
    } catch(ex: Exception) {
        ex.printStackTrace()
    }

    private fun makeEvent(command: Int, channel: Int, note: Int, velocity: Int, tick: Int): MidiEvent {
        val a = ShortMessage()
        a.setMessage(command, channel, note, velocity)

        return MidiEvent(a, tick.toLong())
    }
}