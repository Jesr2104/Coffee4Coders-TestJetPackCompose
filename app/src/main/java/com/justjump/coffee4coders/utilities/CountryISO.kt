package com.justjump.coffee4coders.utilities

import com.justjump.coffee4coders.R

enum class CountryISO(val iso: String){
    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("NIC");

    fun getBackgroundImage(): Int {
        return when(this){
            COL -> R.drawable._co
            BRA -> R.drawable._br
            CRI -> R.drawable._ri
            NIC -> R.drawable._ni
        }
    }

    fun getBackgroundCountryFlag(): Int {
        return when(this){
            COL -> R.drawable.flagco
            BRA -> R.drawable.flagbr
            CRI -> R.drawable.flagri
            NIC -> R.drawable.flagni
        }
    }
}