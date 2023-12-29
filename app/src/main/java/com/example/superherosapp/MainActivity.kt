package com.example.superherosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superherosapp.data.HeroRegistry
import com.example.superherosapp.data.HeroRegistry.superheroes
import com.example.superherosapp.data.Superhero
import com.example.superherosapp.ui.theme.SuperherosAppTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperherosAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHeroApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroApp(){
    Scaffold(
        topBar = {
            SuperHeroTopBar()
        }
    ) {
        it ->
        LazyColumn(contentPadding = it){
            items(superheroes){
                SuperHeroItem(heroList = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroTopBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Superheroes",
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroItem(
    heroList: Superhero
){
    var expanded by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer, label ="Color Animation"
    )
    Card(
        modifier = Modifier
            .padding(
            start = dimensionResource(id = R.dimen.padding_normal),
            end = dimensionResource(id = R.dimen.padding_normal),
            top = dimensionResource(id = R.dimen.padding_small),
            bottom = dimensionResource(id = R.dimen.padding_small)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        ),
        onClick = { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
                .background(color = color)
        ) {
            Row {
                SuperHeroIcon(heroList.imageResource)
                SuperHeroText(heroList.name, heroList.quirk)
            }
            if (expanded){
                SuperHeroAbout(heroList.about)
            }
        }
    }
}

@Composable
fun SuperHeroIcon(
    @DrawableRes icon: Int
){
    Image(
        painter = painterResource(id = icon),
        contentDescription = "null",
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .padding(dimensionResource(id = R.dimen.padding_normal))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun SuperHeroText(
    @StringRes name: Int,
    @StringRes quirk: Int
){
    Column(
        modifier = Modifier
//            .padding(dimensionResource(id = R.dimen.padding_normal))
            .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(id = name),
            modifier = Modifier,
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(id = quirk),
            modifier = Modifier,
            style = MaterialTheme.typography.bodyLarge

        )
    }
}

@Composable
fun SuperHeroAbout(
    @StringRes about: Int
){
    Column {
        Text(
            text = "About: ",
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_normal))
        )
        Text(
            text = stringResource(id = about),
            modifier = Modifier.padding(
                start = dimensionResource(id = R.dimen.padding_normal),
                bottom = dimensionResource(id = R.dimen.padding_normal),
                end = dimensionResource(id = R.dimen.padding_normal)
            )
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SuperheroPreview() {
    SuperherosAppTheme(darkTheme = false) {
        SuperHeroApp()
    }
}