fun main() {
    val forecastt = MigrationForecastt()
    println(forecastt.predictMovement("sunny", 3, "south"))

    println(forecastt.predictWaterCrossing(7))

    println(forecastt.predictPredatorAttack("west"))

    val planner = MoviePlanner()
    val project1 = MovieProject("The Lion King", mutableListOf("Simba", "Nala"), "June 2022", 2000000.0)
    val project2 =
        MovieProject("Friends", mutableListOf("Lis Kudrow", "MattLe Blanc", "Matthew Perry"), "August 2023", 450000000.0)
    planner.addProject(project1)
    planner.addProject(project2)
    planner.removeProject(project1)

    val newCastMembers = mutableListOf("Simba", "Nala", "Timon", "Pumbaa")
    project1.addCastMember("Mark Ruffalo")
    project1.removeCastMember("Scarlett Johansson")
    project2.updateShootingSchedule("October 2023")
    planner.updateProjectDetails(project1, newCastMembers, "July 2022", 1500000.0)
    planner.generateReport()
    project1.adjustBudget(-60000000.0)
}
    //Every year, millions of wildebeest, zebras, and other animals participate in great migration
//across the Serengeti -Mara ecosystem. As a conservationist, you want to develop a software system
//that models this migration, predicting the movement of the herds based on the weather patterns,
//rivers levels, predator locations, and the various factors that influence the migration .
    class MigrationForecast {
        fun predictMovement(weather: String, riverLevel: Int, predatorLocation: String): String {
            if (weather == "sunny" && riverLevel < 5 && predatorLocation == "south") {
                return "The herds will move north."
            } else if (weather == "rainy" && riverLevel > 10 && predatorLocation == "west") {
                return "The herds will move east."
            } else {
                return "The herds will stay put."
            }
        }
    }

    class MigrationForecastt {
        fun predictMovement(weather: String, riverLevel: Int, predatorLocation: String): String {
            if (weather == "sunny" && riverLevel < 5 && predatorLocation == "south") {
                return "The herds will move north"
            } else if (weather == "rainy" && riverLevel > 10 && predatorLocation == "west") {
                return "The herds will move east"
            } else {
                return "The herds will stay in their current location"
            }
        }
        fun predictWaterCrossing(riverLevel: Int): String {
            if (riverLevel > 5 && riverLevel < 10) {
                return "The herds will attempt to cross the river"
            } else if (riverLevel >= 10) {
                return "The herds will not attempt to cross the river"
            } else {
                return "The herds will easily cross the river"
            }
        }
        fun predictPredatorAttack(predatorLocation: String): String {
            if (predatorLocation == "north") {
                return "The herds will move south to avoid predators"
            } else if (predatorLocation == "east") {
                return "The herds will move west to avoid predators"
            } else {
                return "The herds are safe from predators"
            }
        }
    }

    //AS a producer in the booming Nollywood movie industry , you are in charge of multiple
//film projects at once.Each movie has different cast members , shooting schedules , and budgets .
//You want to write a program to help manage your film projects efficiently .
//The software should be able to handle the complexities of scheduling ,budgeting and
//coordinating between different movie projects.
    class MovieProject(
        val title: String,
        var castMembers: MutableList<String>,
        var shootingSchedule: String,
        var budget: Double
    ) {
        fun addCastMember(castMember: String) {
            castMembers.add(castMember)
        }

        fun removeCastMember(castMember: String) {
            if (castMembers.contains(castMember)) {
                castMembers.remove(castMember)
            } else {
                println("$castMember is not a cast member of this project.")
            }
        }
        fun updateShootingSchedule(schedule: String) {
            shootingSchedule = schedule
        }

        fun adjustBudget(amount: Double) {
            if (budget + amount >= 0) {
                budget += amount
            } else {
                println("Error: Budget cannot be negative.")
            }
        }
    }

    class MoviePlanner {
        val projects = mutableListOf<MovieProject>()

        fun addProject(project: MovieProject) {
            projects.add(project)
        }
        fun removeProject(project: MovieProject) {
            if (projects.contains(project)) {
                projects.remove(project)
            } else {
                println("${project.title} is not a project in the planner.")
            }
        }
        fun updateProjectDetails(project: MovieProject, castMembers: MutableList<String>, schedule: String, budget: Double) {
            project.castMembers = castMembers
            project.shootingSchedule = schedule
            project.budget = budget
        }
        fun generateReport() {
            for (project in projects) {
                println("Title: ${project.title}")
                println("Cast Members: ${project.castMembers}")
                println("Shooting Schedule: ${project.shootingSchedule}")
                println("Budget: ${project.budget}")
                println()
            }
        }
    }