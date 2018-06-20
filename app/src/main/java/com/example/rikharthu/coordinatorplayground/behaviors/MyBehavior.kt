package com.example.rikharthu.coordinatorplayground.behaviors

import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.util.Log
import android.view.View


class MyBehavior : CoordinatorLayout.Behavior<View>() {

    // will be called every time that something happens in the layout,
    // what we must do to return true once we identify the dependency,
    // in the example, this method is automatically fired when the user scrolls
    // (because the Toolbar will move)
    override fun layoutDependsOn(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
//        Log.d("MyBehavior", "layoutDependsOn $dependency")
        return dependency is AppBarLayout
    }

    // Called whenever layoutDependsOn returns true
    // implement animations, translations or moevements related with the provided dependency
    override fun onDependentViewChanged(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
//        Log.d("MyBehavior", "onDependentViewChanged")
        val appBar = dependency as AppBarLayout
        val range = appBar.totalScrollRange
        val factor = -appBar.y / range

        val appBarWidth=appBar.width
        child.x=(appBarWidth-child.width)*factor

        child.y = parent.y
        return true
    }
}