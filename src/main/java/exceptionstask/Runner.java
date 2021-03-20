package exceptionstask;


import exceptionstask.entities.university.*;
import exceptionstask.types.DepartmentType;
import exceptionstask.types.GroupType;
import exceptionstask.types.SubjectType;

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
        UniversityUtilities.calculateAverageGradeForStudent(university, "student2");
        UniversityUtilities.calculateAverageGradeForSubjectGroupDepartment(
                university, SubjectType.ENGLISH, GroupType.GRP_4, DepartmentType.INFORMATIZATION);
        UniversityUtilities.calculateAverageGradeForSubject(university, SubjectType.BIOLOGY);
    }
}