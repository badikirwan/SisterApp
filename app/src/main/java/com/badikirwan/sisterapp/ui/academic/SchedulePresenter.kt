package com.badikirwan.sisterapp.ui.academic

import com.badikirwan.sisterapp.model.Schedule

class SchedulePresenter(view: ScheduleContract.View): ScheduleContract.Presenter {

    private var view: ScheduleContract.View? = view
    private val listSchedule = listOf(
        Schedule("Semester 1","PSIKOLOGI KOGINITF", "M. WARDIANTO, S.Psi., M.Psi", "Ruang H5", "08.00 - 09.30"),
        Schedule("Semester 1","PSIKOLOGI KOGINITF", "M. WARDIANTO, S.Psi., M.Psi", "Ruang H5", "08.00 - 09.30"),
        Schedule("Semester 1","PSIKOLOGI KOGINITF", "M. WARDIANTO, S.Psi., M.Psi", "Ruang H5", "08.00 - 09.30"),
        Schedule("Semester 1","PSIKOLOGI KOGINITF", "M. WARDIANTO, S.Psi., M.Psi", "Ruang H5", "08.00 - 09.30"),
        Schedule("Semester 1","PSIKOLOGI KOGINITF", "M. WARDIANTO, S.Psi., M.Psi", "Ruang H5", "08.00 - 09.30"),
        Schedule("Semester 1","PSIKOLOGI KOGINITF", "M. WARDIANTO, S.Psi., M.Psi", "Ruang H5", "08.00 - 09.30"),
        Schedule("Semester 1","PSIKOLOGI KOGINITF", "M. WARDIANTO, S.Psi., M.Psi", "Ruang H5", "08.00 - 09.30"),
        Schedule("Semester 1","PSIKOLOGI KOGINITF", "M. WARDIANTO, S.Psi., M.Psi", "Ruang H5", "08.00 - 09.30"),
        Schedule("Semester 1","PSIKOLOGI KOGINITF", "M. WARDIANTO, S.Psi., M.Psi", "Ruang H5", "08.00 - 09.30"),
        Schedule("Semester 1","PSIKOLOGI KOGINITF", "M. WARDIANTO, S.Psi., M.Psi", "Ruang H5", "08.00 - 09.30")
    )

    override fun setAcademic() {
        val listSemester = arrayOf("Semester 1", "Semester 2", "Semester 3")
        view?.hideLoading()
        view?.showAcademic(listSemester)
    }

    override fun setSchedule() {
        view?.hideLoading()
        view?.showSchedule(listSchedule)
    }

    override fun getCourseSchedule(semester: String) {
        val data = listSchedule.filter {
            it.semester == semester
        }

        view?.showSchedule(data)
    }

    override fun onDestroy() {
        this.view = null
    }
}