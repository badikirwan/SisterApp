package com.badikirwan.sisterapp.ui.academic

import com.badikirwan.sisterapp.model.Academic
import com.badikirwan.sisterapp.ui.base.BasePresenter
import com.badikirwan.sisterapp.ui.base.BaseView

interface AcademicContract {

    interface Presenter : BasePresenter {
        fun getAcademic()
        fun setAcademic()
        fun setSemester()
    }

    interface View : BaseView<Presenter> {
        fun showAcademic(listAcademic: List<Academic>)
        fun showSemester(listSemester: Array<String>)
        fun showError()
    }
}