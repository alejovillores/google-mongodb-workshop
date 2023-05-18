@file:OptIn(ExperimentalMaterial3Api::class)
package com.mongodb.talktome.views
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mongodb.talktome.R
import com.mongodb.talktome.ui.theme.TalkToMeTheme
import com.mongodb.talktome.viewmodels.TalksListViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TalksListView(viewModel: TalksListViewModel,modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = stringResource(id = R.string.app_name))

            })
        },

        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.addButtonTapped()
            }) {
                Icon(Icons.Filled.Add, "Add talks")
            }
        }

    ) { innerPadding ->
        val talks by viewModel.talks.observeAsState(emptyList())
        LazyColumn(contentPadding = innerPadding) {
            items(talks) {
                talk ->
                TalkListItem(title = talk.title, speaker = talk.speaker)
            }
        }
    }
}


@Composable
fun TalkListItem(title: String, speaker: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = title)
        Divider()
    }
}



/* Para que podamos ir viendo como va quedando a medida que vamos diseñando
// Funcion especifica para ver diferentes componentes
//@Preview(showBackground = true)
//@Composable
//fun TalksListViewPreview() {
    // TalkToMeTheme es para definir los parametros por default
    TalkToMeTheme {
        //TalksListView()
    }
}*/
