package evgen.kolesnik.domain.outcome

sealed class Outcome<T> {

    data class Progress<T>(var loading: Boolean) : Outcome<T>()
    data class Next<T>(var data: T) : Outcome<T>()
    data class Success<T>(var data: T) : Outcome<T>()
    data class Failure<T>(var exception: Throwable) : Outcome<T>()

    companion object {
        fun <T> loading(isLoading: Boolean): Outcome<T> = Progress(isLoading)
        fun <T> next(data: T): Outcome<T> = Next(data)
        fun <T> success(data: T): Outcome<T> = Success(data)
        fun <T> failure(exception: Throwable): Outcome<T> = Failure(exception)
    }
}