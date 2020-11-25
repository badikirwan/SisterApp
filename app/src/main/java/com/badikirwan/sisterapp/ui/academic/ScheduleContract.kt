package com.badikirwan.sisterapp.ui.academic

import com.badikirwan.sisterapp.model.Schedule
import com.badikirwan.sisterapp.ui.base.BasePresenter
import com.badikirwan.sisterapp.ui.base.BaseView

interface ScheduleContract {

    interface Presenter: BasePresenter {
        fun setAcademic()
        fun setSchedule()
        fun getCourseSchedule(semester: String)
    }

    interface View: BaseView<Presenter> {
        fun showAcademic(listSemester: Array<String>)
        fun showSchedule(listSchedule: List<Schedule>)
    }
}