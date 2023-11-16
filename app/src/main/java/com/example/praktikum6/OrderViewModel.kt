package com.example.praktikum6

import androidx.lifecycle.ViewModel
import com.example.praktikum6.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat


private const val HARGA_PER_CUP = 3000
class OrderViewModel : ViewModel(){
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setJumlah(jmlEsJumbo: Int) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlEsJumbo,
                harga = hitungHarga(jumlah = jmlEsJumbo)

            )
        }
    }

    fun setContact(ListContact: MutableList <String>){
        _stateUI.update{stateSaatIni ->
            stateSaatIni.copy(
                name = ListContact[0],
                notlp = ListContact[1],
                almt = ListContact[2]
            )
        }
    }

    fun resetOrder() {
        _stateUI.value = OrderUIState()
    }

    private fun hitungHarga(jumlah: Int = _stateUI.value.jumlah): String {
        val kalkulasiHarga = jumlah * HARGA_PER_CUP

        return NumberFormat.getNumberInstance().format(kalkulasiHarga)


    }

}