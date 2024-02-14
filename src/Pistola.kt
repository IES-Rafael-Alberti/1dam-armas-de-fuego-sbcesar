class Pistola(
    municion: Int,
    tipoDeMunicion: String,
    danio: Int,
    radio: TiposRadio
): ArmaDeFuego("Pistola",municion,1,tipoDeMunicion) {

    override var danio: Int = danio
        set(value) {
            requireDanio(value)
            field = value
        }

    override var radio: TiposRadio = radio
        set(value) {
            requireRadio(value)
            field = value
        }

    init {
        requireDanio(danio)
        requireRadio(radio)
    }

    fun requireDanio(danio: Int) {
        require(danio in 1..5) {  }
    }

    fun requireRadio(radio: TiposRadio) {
        require(radio in TiposRadio.CORTO..TiposRadio.ENORME) {  }
    }

    override fun toString(): String {
        return "${super.toString()} "
    }
}