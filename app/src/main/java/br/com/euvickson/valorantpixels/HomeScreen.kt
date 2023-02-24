package br.com.euvickson.valorantpixels

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.euvickson.valorantpixels.ui.theme.ValorantPixelsTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    ValorantPixelsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            var agentsButtonValue by remember { mutableStateOf(false) }

            ModalNavigationDrawer(

                drawerContent = {

                    Text(text = "Valorant Pixels")
                    Divider(
                        modifier = Modifier
                            .width(300.dp)
                            .align(Alignment.CenterHorizontally), color = Color.LightGray
                    )
                    Text(text = "Coleção de Miras")

                    IconButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { agentsButtonValue = !agentsButtonValue }) {
                        Row {
                            Text(text = "Agentes")
                            Icon(
                                imageVector = if (agentsButtonValue) Icons.Outlined.KeyboardArrowDown else Icons.Outlined.KeyboardArrowRight,
                                contentDescription = "Ícone de ver mais"
                            )
                        }
                    }
                    LazyColumn(content = {
                        val listaDePersonagens = listOf("Brimstone", "Fade", "Sova", "Viper")
                        items(4) {
                            AgenteItem(agentsButtonValue, listaDePersonagens[it])
                        }
                    })
                    Text(text = "Comunidade")
                    Text(text = "Quem Somos")
                },
                drawerState = drawerState
            ) {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {},
                            navigationIcon = {
                                IconButton(onClick = { scope.launch { if (drawerState.isClosed) drawerState.open() else drawerState.close() } }) {
                                    Icon(
                                        imageVector = Icons.Filled.Menu,
                                        contentDescription = "Menu Icon"
                                    )
                                }
                            }
                        )
                    },
                    content = { innerPadding ->
                        //The main screen itens will be placed right here
                        LazyColumn(
                            contentPadding = innerPadding,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(1) {
                                Text(text = "Teste 1")
                                Text(text = "Teste 2")
                                Text(text = "Teste 3")
                                Text(text = "Teste 4")
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun ColumnScope.AgenteItem(agentsButtonValue: Boolean, nomeDoAgente: String) {
    AnimatedVisibility(visible = agentsButtonValue) {
        var agentMapsButtonValue by remember { mutableStateOf(false) }
        Column(modifier = Modifier) {
            IconButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { agentMapsButtonValue = !agentMapsButtonValue }) {
                Row(modifier = Modifier.clip(RoundedCornerShape(15.dp)).background(Color.LightGray).padding(horizontal = 75.dp)) {
                    Text(text = nomeDoAgente)
                    Icon(
                        imageVector = if (agentMapsButtonValue) Icons.Outlined.KeyboardArrowDown else Icons.Outlined.KeyboardArrowRight,
                        contentDescription = "Ícone de ver mais dos mapas do agente"
                    )
                }
            }
            AnimatedVisibility(
                visible = agentMapsButtonValue,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Column(modifier = Modifier.wrapContentHeight()) {
                    Button(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(150.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Ascent")
                    }
                    Button(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(150.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Bind")
                    }
                    Button(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(150.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Haven")
                    }
                    Button(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(150.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Icebox")
                    }
                }
            }
        }
    }
}