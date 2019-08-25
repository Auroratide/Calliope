import com.auroratide.calliope.*

fun main() {
    val player = Player()
    player.play(scale)
}

val track = instrument(Piano) {
    play(C4)
    play(D4)
    play(E4)
    play(F4)
    play(G4)
    play(A5)
    play(B5)
    play(C5)
}

val scale = song("C scale") {
    bpm = 180.0

    tracks(track)
}
