import kotlin.random.Random

abstract class ArmaDeFuego(private val nombre: String, private var municion: Int, private val municionARestar: Int, private val tipoDeMunicion: String, var cantidadMunicionExtra: Int = Random.nextInt(5,15)) {

    val danio: Int = 0
    var radio: String = ""
        set(value) {
            radio.capitalize()
            requireRadio()
            field = value
        }

    init {
        requireRadio()
    }

    fun dispara() {
        if (municion == 0) {
            recargar()
            municion -= municionARestar
        }
        municion -= municionARestar
    }

    fun recargar(): Boolean {
        val municionInicial = municion
        dispara()
        if (municion <= 0) {
            cantidadMunicionExtra -= 1
            if (cantidadMunicionExtra == -1) {
                println("No hay suficiente munición extra para recargar.")
                return false
            } else {
                println("$nombre recargado correctamente.")
            }
        } else {
            municion = municionInicial
            println("$nombre recargado correctamente.")
            return true
        }
        return true
    }

    private fun requireRadio() {
        require(radio !in listOf<String>("Reducido","Corto","Intermedio","Amplio","Enorme")) { "Radio del arma erróneo" }
        //require(radio !in TiposRadio) { "Alcance del arma erróneo" }
    }

    override fun toString(): String {
        return "Nombre: $nombre Municion: $municion Tipo de municion: $tipoDeMunicion Daño: $danio Radio: $radio"
    }


}