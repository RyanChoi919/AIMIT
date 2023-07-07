package com.nodes.aimit.domain.model

import com.nodes.aimit.R

enum class GoalType(val labelResId: Int) {
    TARGET(R.string.goal_type_target),
    AVERAGE(R.string.goal_type_average),
    SUCCESS_RATE(R.string.goal_type_success_rate),
    STREAK(R.string.goal_type_streak)
}