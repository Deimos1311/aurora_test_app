package evgen.kolesnik.data.util

import androidx.annotation.StringRes

interface ResourceProvider {

    fun string(@StringRes id: Int): String

}