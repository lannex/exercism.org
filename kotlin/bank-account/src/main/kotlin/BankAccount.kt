class BankAccount {
    private var isOpen: Boolean = true

    var balance: Long = 0
        get() {
            check(isOpen)
            return field
        }
        private set

    @Synchronized
    fun adjustBalance(amount: Long) {
        check(isOpen)
        balance += amount
    }

    fun close() {
        isOpen = false
    }
}
