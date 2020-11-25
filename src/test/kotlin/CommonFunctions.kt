import com.mellonita.blackboxkt.CrossInTray
import com.mellonita.blackboxkt.Rastrigin5D
import com.mellonita.blackboxkt.XinSheYangN4_10D
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe

class CommonFunctions : StringSpec({

    "Rastrigin"{
        Rastrigin5D(DoubleArray(5) { 0.0 }) shouldBe Rastrigin5D.globalMinima
    }

    "Cross-in-Tray" {
        CrossInTray(doubleArrayOf(1.3491, -1.3491)) shouldBe CrossInTray.globalMinima.plusOrMinus(1E-5)
    }

    "XinSheYangN4"{
        XinSheYangN4_10D(DoubleArray(10) { 0.0 }) shouldBe XinSheYangN4_10D.globalMinima
    }

})