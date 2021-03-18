package errorAndExceptions;


import errorAndExceptions.entities.university.*;
import errorAndExceptions.types.DepartmentType;
import errorAndExceptions.types.GroupType;
import errorAndExceptions.types.SubjectType;

/**
 * В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы.
 * У каждого студента есть несколько учебных предметов по которым он получает оценки.
 * Необходимо реализовать иерархию студентов, групп и факультетов.
 * Посчитать средний балл по всем предметам студента
 * Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
 * Посчитать средний балл по предмету для всего университета
 *
 * Релизовать следующие исключения:
 * Оценка ниже 0 или выше 10
 * Отсутсвие предметов у студента (должен быть хотя бы один)
 * Отсутствие студентов в группе
 * Отсутствие групп на факультете
 * Отсутствие факультетов в университете
 */
public class Runner {
    public static void main(String[] args) {
        University university = UniversityCreator.createUniversity();
        UniversityUtilities.showAverageGradeForStudent(university, "student2");
        UniversityUtilities.showAverageGradeForSubjectGroupDepartment(
                university, SubjectType.ENGLISH, GroupType.GRP_5, DepartmentType.INFORMATIZATION);
        UniversityUtilities.showAverageGradeForSubject(university, SubjectType.BIOLOGY);
    }
}
// спросить если ли смысл кидать везде RuntimeException
// UniversityUtilities нужно ли писать дополнительные исключения для этих методов или
// изменить уже существющие исключения(или оставить на "логике -1")