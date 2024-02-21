import kotlin.random.Random

abstract class ArmaDeFuego(
    private val nombre: String,
    private var municion: Int,
    private val municionARestar: Int,
    private val tipoDeMunicion: String,
) {
    abstract val danio: Int
    abstract var radio: TiposRadio

    companion object {
        var cantidadMunicionExtra: Int = Random.nextInt(5,16)
    }

    fun dispara() {
        if (municion >= municionARestar || recargar()) {
            municion -= municionARestar
            println("$nombre dispara. Municion restante: $municion")
        } else {
            println("No hay suficiente municion para disparar")
        }
    }

    private fun recargar() =
        if (cantidadMunicionExtra >= municionARestar) {

            val cantidad =
                if (cantidadMunicionExtra >= (municionARestar * 2)) municionARestar else municionARestar

            municion += cantidad
            cantidadMunicionExtra -= cantidad

            println("$nombre recargada. Municion restante $municion")
            true
        } else {
            println("No hay suficiente municion extra para recargar")
            false
        }

    override fun toString(): String {
        return "Nombre: $nombre Municion: $municion Tipo de municion: $tipoDeMunicion Daño: $danio Radio: ${radio.desc}"
    }


}