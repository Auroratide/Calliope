package midimaker

import javax.sound.midi.MidiSystem

class Player {
    fun play(song: Song) {
        val sequencer = MidiSystem.getSequencer()
        sequencer.open()

        sequencer.sequence = song.sequence
        sequencer.tempoInBPM = song.bpm.toFloat()
        sequencer.start()

        while(sequencer.isRunning) {}
        sequencer.close()
    }
}