package midimaker

import javax.sound.midi.MidiEvent
import javax.sound.midi.ShortMessage
import javax.sound.midi.Track

class InstrumentTrack {
    private var tick: Long = 4
    private val events: MutableList<MidiEvent> = mutableListOf()

    fun play(note: Note) {
        events.add(MidiEvent(ShortMessage(144, 1, note.pitch.toInt(), 100), tick))
        events.add(MidiEvent(ShortMessage(128, 1, note.pitch.toInt(), 100), tick + 2))

        tick += 4
    }

    fun applyToMidi(track: Track) {
        events.forEach { track.add(it) }
    }
}

fun instrument(instrument: Instrument, body: InstrumentTrack.() -> Unit): InstrumentTrack {
    val i = InstrumentTrack()
    i.body()
    return i
}