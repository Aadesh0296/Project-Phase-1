using Microsoft.AspNetCore.Mvc;

using CollegeApp.Services;

namespace CollegeApp.Controllers;

public class HomeController : Controller
{
    public IActionResult Index([FromServices] Services.CollegeDbContext db)
    {
        return View(db);
    }

}