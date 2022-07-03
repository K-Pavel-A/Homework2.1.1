
import junit.framework.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun calculateComission_ForMirVisaCard_LessLimit() {
        val cardTypeTest = "Мир"
        val transferAmountTest = 3339
        val amountPerMonthTest = 0

        val result = calculateComission(cardType = cardTypeTest, amountPerMonth = amountPerMonthTest, transferAmount = transferAmountTest)
        val expectedComission = 3500

        assertEquals(expectedComission, result)
    }

    @Test
    fun calculateComission_ForMirVisaCard_MoreLimit() {
        val cardTypeTest = "Visa"
        val transferAmountTest = 1000_00
        val amountPerMonthTest = 0

        val result = calculateComission(cardType = cardTypeTest, amountPerMonth = amountPerMonthTest, transferAmount = transferAmountTest)
        val expectedComission = 750

        assertEquals(expectedComission, result)
    }
    @Test
    fun calculateComission_ForMaestroMasterCard_LessLimit() {
        val cardTypeTest = "Maestro"
        val transferAmountTest = 100_000_00
        val amountPerMonthTest = 80_000_00

        val result = calculateComission(cardType = cardTypeTest, amountPerMonth = amountPerMonthTest, transferAmount = transferAmountTest)
        val expectedComission = 620_00

        assertEquals(expectedComission, result)
    }

    @Test
    fun calculateComission_ForMaestroMasterCard_MoreLimit() {
        val cardTypeTest = "Mastercard"
        val transferAmountTest = 72_000_00
        val amountPerMonthTest = 0

        val result = calculateComission(cardType = cardTypeTest, amountPerMonth = amountPerMonthTest, transferAmount = transferAmountTest)
        val expectedComission = 0

        assertEquals(expectedComission, result)
    }

    @Test
    fun calculateComission_ForVkPay() {
        val cardTypeTest = "Vk Pay"
        val transferAmountTest = 72_000_00
        val amountPerMonthTest = 0

        val result = calculateComission(cardType = cardTypeTest, amountPerMonth = amountPerMonthTest, transferAmount = transferAmountTest)
        val expectedComission = 0

        assertEquals(expectedComission, result)
    }

    @Test
    fun transfer_MirVisa_MoreLimit() {
        val cardTypeTest = "Visa"
        val transferAmountTest = 10000_00
        val amountperMonthTest = 0

        val result = transfer(cardType = cardTypeTest, amountPerMonth = amountperMonthTest, transferAmount = transferAmountTest)
        val expectedTransfer = 9925_00

        assertEquals(expectedTransfer, result)
    }

    @Test
    fun transfer_MirVisa_LessLimit() {
        val cardTypeTest = "Мир"
        val transferAmountTest = 3300
        val amountperMonthTest = 0

        val result = transfer(cardType = cardTypeTest, amountPerMonth = amountperMonthTest, transferAmount = transferAmountTest)
        val expectedTransfer = 0

        assertEquals(expectedTransfer, result)
    }

    @Test
    fun transfer_MaestroMastercard_MoreLimit() {
        val cardTypeTest = "Maestro"
        val transferAmountTest = 1000_00
        val amountperMonthTest = 80_000_00

        val result = transfer(cardTypeTest, amountperMonthTest, transferAmountTest)
        val expectedTransfer = 97400

        assertEquals(expectedTransfer, result)
    }

    @Test
    fun transfer_MaestroMastercard_LessLimit() {
        val cardTypeTest = "Mastercard"
        val transferAmountTest = 3300
        val amountPerMonthTest = 69_000_00

        val result = transfer(cardTypeTest, amountPerMonthTest, transferAmountTest)
        val expectedTransfer = 3300

        assertEquals(expectedTransfer, result)
    }

    @Test
    fun transfer_VkPay() {
        val cardTypeTest = "Vk Pay"
        val transferAmountTest = 5000_00
        val amountPerMonthTest = 0

        val result = transfer(cardTypeTest, amountPerMonthTest, transferAmountTest)
        val expectedTransfer = 5000_00

        assertEquals(expectedTransfer, result)
    }

}

