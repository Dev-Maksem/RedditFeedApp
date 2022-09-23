package ua.devmaksem.network.factory

/**
 * The factory will help decoupling the creation of retrofit service.
 */
internal interface ServiceFactory<T> {
    fun createService(jsonAdapters: List<Any> = emptyList()): T
    fun createAuthService(): T
}