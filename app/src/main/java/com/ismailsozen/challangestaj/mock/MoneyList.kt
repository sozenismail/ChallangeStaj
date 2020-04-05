package com.ismailsozen.challangestaj.mock

import com.ismailsozen.challangestaj.model.MoneyModel

object MoneyList {

    fun getMockedMoneyList(): List<MoneyModel> {


        val moneyModel = MoneyModel(
            "https://i.dlpng.com/static/png/6646535_preview.png",
            "İsmail Sözen",
            888.5,
            "BTC DETAİL"

        )

        val moneyModel2 = MoneyModel(
            "https://i.dlpng.com/static/png/6646535_preview.png",
            "Haydar Sözen",
            884.5,
            "EFC DETAİL"
        )

        val moneyList: ArrayList<MoneyModel> = ArrayList()

        moneyList.add(moneyModel)
        moneyList.add(moneyModel2)
        moneyList.add(moneyModel)
        moneyList.add(moneyModel2)
        moneyList.add(moneyModel)
        moneyList.add(moneyModel2)



        return moneyList
    }


}