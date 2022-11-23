using Microsoft.AspNetCore.Mvc;

using CollegeApp.Services;

namespace CollegeApp.Controllers;

public class StudentControllers : Controller
{
    [HttpGet]
    [Route("Student/Studentdetail/{id}")]

    public IActionResult Studentdetail(string id)
    {
        var db = new CollegeDbContext();

        var course = id;

        ViewBag.course = db.Students
                .Where( p => p.CourseId == course)
                .ToList();
            
        return View("Studentdetail");
    }

}