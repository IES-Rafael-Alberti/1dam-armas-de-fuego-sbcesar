class Pistola(nombre: String, municion: Int, tipoDeMunicion: String, municionARestar: Int, cantidadMunicionExtra: Int,): ArmaDeFuego(nombre,municion,municionARestar,tipoDeMunicion,cantidadMunicionExtra) {

    override fun dispara() {
        TODO("Not yet implemented")
    }

    override fun recargar() {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "${super.toString()} "
    }
}