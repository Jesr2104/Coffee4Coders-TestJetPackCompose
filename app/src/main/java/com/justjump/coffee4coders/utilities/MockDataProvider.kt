package com.justjump.coffee4coders.utilities

import com.justjump.coffee4coders.models.data.local.Product

object MockDataProvider {
    fun listOfProducts(): List<Product> = listOf(
        Product(
            0,
            "Colombian Coffee",
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
            "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
            55.0,
            "USD",
            "COL"
        ),
        Product(
            1,
            "Brazilian coffee",
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
            "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
            40.0,
            "USD",
            "BRA"
        ),
        Product(
            2,
            "Costa Ríca coffee",
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
            "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
            35.0,
            "USD",
            "CRI"
        ),
        Product(
            3,
            "Nicaraguan coffee",
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
            "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
            50.0,
            "USD",
            "NIC"
        ),
    )

    fun getProductById(id: Int) : Product? {
        return listOfProducts().find { item -> item.id == id }
    }


    fun listOfCities(): List<String> = listOf(
        "Ciudad de México, México",
        "La Havana, Cuba",
        "Medellín, Colombia",
        "Buenos Aires, Argentina",
        "Sao Pablo, Brasil",
        "Lima, Perú",
        "Montivideo, Uruguay",
        "Ciudad de Panamá, Panamá"
    )

}