package ua.itaysonlab.hfsdk

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.ColorInt
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FeedCategory(
    val id: String,
    val title: String,
    @ColorInt val category_color: Int,
    val server_icon: String?
) : Parcelable {
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {

    }
}