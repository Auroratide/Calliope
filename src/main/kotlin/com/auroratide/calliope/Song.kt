package com.auroratide.calliope

import javax.sound.midi.Sequence

class Song {
    var bpm: Double = 120.0
    val sequence = Sequence(Sequence.PPQ, 4)

    fun tracks(track: InstrumentTrack) {
        val midiTrack = sequence.createTrack()
        track.applyToMidi(midiTrack)
    }
}

fun song(name: String, body: Song.() -> Unit): Song {
    val s = Song()
    s.body()
    return s
}