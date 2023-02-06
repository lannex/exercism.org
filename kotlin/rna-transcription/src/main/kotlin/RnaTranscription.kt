fun transcribeToRna(dna: String): String =
    dna.map {
        when (it) {
            'C' -> "G"
            'G' -> "C"
            'T' -> "A"
            'A' -> "U"
            else -> it
        }
    }.joinToString("")
