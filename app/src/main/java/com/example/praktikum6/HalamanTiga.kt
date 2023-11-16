package com.example.praktikum6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.praktikum6.data.OrderUIState

@Composable
fun HalamanTiga(
    orderUIState: OrderUIState,
    onBackButtonClicked: () -> Unit
){
    val items = listOf(
        Pair(stringResource(R.string.quantity), orderUIState.jumlah),
        Pair(stringResource(R.string.flavor), orderUIState.rasa)
    )

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ){

        Text(text = stringResource(id = R.string.name))
        Text(text = orderUIState.name)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))


        Text(text = stringResource(id = R.string.almt))
        Text(text = orderUIState.almt)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))


        Text(text = stringResource(id = R.string.notlp))
        Text(text = orderUIState.notlp)
        Divider()
        Spacer(modifier = Modifier.padding(8.dp))

        Column (
            modifier = Modifier.fillMaxWidth()
        ){
            items.forEach{ item ->
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)){
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            }

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

            FormatLabelHarga(
                subtotal = orderUIState.harga,
                modifier = Modifier.align(Alignment.End)
            )
        }



        Row (
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium))
        ){
            Column (
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ){
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { }
                ) {
                    Text(stringResource(R.string.send))
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onBackButtonClicked
                ) {
                    Text(stringResource(R.string.bck_btn))
                }
            }
        }
    }
}