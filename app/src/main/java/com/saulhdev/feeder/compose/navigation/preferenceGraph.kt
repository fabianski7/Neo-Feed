/*
 * This file is part of Neo Feed
 * Copyright (c) 2022   Saul Henriquez <henriquez.saul@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.saulhdev.feeder.compose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
inline fun NavGraphBuilder.preferenceGraph(
    route: String,
    crossinline root: @Composable () -> Unit,
    crossinline block: NavGraphBuilder.(subRoute: (String) -> String) -> Unit = { }
) {
    val subRoute: (String) -> String = { name -> "$route$name/" }
    composable(route = route) {
        CompositionLocalProvider(LocalRoute provides route) {
            root()
        }
    }
    block(subRoute)
}

val LocalRoute = compositionLocalOf { "" }

@Composable
fun subRoute(name: String) = "${LocalRoute.current}$name/"