package com.example.superherosapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superherosapp.R

data class Superhero(
    @DrawableRes val imageResource: Int,
    @StringRes val name: Int,
    @StringRes val quirk: Int,
    @StringRes val about: Int
)

object HeroRegistry {
    val superheroes = listOf<Superhero>(
        Superhero(R.drawable.izuku_midoriya, R.string.superhero_1, R.string.quirk_1, R.string.description_1),
        Superhero(R.drawable.katsuki_bakugo, R.string.superhero_2, R.string.quirk_2, R.string.description_2),
        Superhero(R.drawable.shoto_todoroki, R.string.superhero_3, R.string.quirk_3, R.string.description_3),
        Superhero(R.drawable.ochaco_uraraka, R.string.superhero_4, R.string.quirk_4, R.string.description_4),
        Superhero(R.drawable.tenya_ida, R.string.superhero_5, R.string.quirk_5, R.string.description_5),
        Superhero(R.drawable.eijiro_kirishima, R.string.superhero_6, R.string.quirk_6, R.string.description_6),
        Superhero(R.drawable.denki_kaminari, R.string.superhero_7, R.string.quirk_7, R.string.description_7),
        Superhero(R.drawable.momo_yaoyorozu, R.string.superhero_8, R.string.quirk_8, R.string.description_8),
        Superhero(R.drawable.yuga_aoyama, R.string.superhero_9, R.string.quirk_9, R.string.description_9),
        Superhero(R.drawable.fumikage_tokoyami, R.string.superhero_10, R.string.quirk_10, R.string.description_10),
        Superhero(R.drawable.mashirao_ojiro, R.string.superhero_11, R.string.quirk_11, R.string.description_11),
        Superhero(R.drawable.hanta_sero, R.string.superhero_12, R.string.quirk_12, R.string.description_12),
        Superhero(R.drawable.mirio_togata, R.string.superhero_13, R.string.quirk_13, R.string.description_13),
        Superhero(R.drawable.shota_aizawa, R.string.superhero_14, R.string.quirk_14, R.string.description_14),
        Superhero(R.drawable.present_mic, R.string.superhero_15, R.string.quirk_15, R.string.description_15),
        Superhero(R.drawable.all_might, R.string.superhero_16, R.string.quirk_16, R.string.description_16),
        Superhero(R.drawable.endeavor, R.string.superhero_17, R.string.quirk_17, R.string.description_17),
        Superhero(R.drawable.all_for_one, R.string.superhero_18, R.string.quirk_18, R.string.description_18),
        Superhero(R.drawable.tomura_shigaraki, R.string.superhero_19, R.string.quirk_19, R.string.description_19),
        Superhero(R.drawable.eri, R.string.superhero_20, R.string.quirk_20, R.string.description_20),
        Superhero(R.drawable.himiko_toga, R.string.superhero_21, R.string.quirk_21, R.string.description_21),
        Superhero(R.drawable.twice, R.string.superhero_22, R.string.quirk_22, R.string.description_22),
        Superhero(R.drawable.dabi, R.string.superhero_23, R.string.quirk_23, R.string.description_23)
    )

}