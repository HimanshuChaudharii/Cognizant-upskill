// Controller Class - Handles communication between Model and View
public class StudentController {
    private Object model;
    private Object view;

    public StudentController(Object model, Object view) {
        this.model = model;
        this.view = view;
    }

    // Getter methods - retrieve data from the model
    public String getStudentName() {
        return (String) invokeModelMethod("getName");
    }

    public String getStudentId() {
        return (String) invokeModelMethod("getId");
    }

    public String getStudentGrade() {
        return (String) invokeModelMethod("getGrade");
    }

    // Setter methods - update data in the model
    public void setStudentName(String name) {
        invokeModelMethod("setName", String.class, name);
    }

    public void setStudentId(String id) {
        invokeModelMethod("setId", String.class, id);
    }

    public void setStudentGrade(String grade) {
        invokeModelMethod("setGrade", String.class, grade);
    }

    // Ask the view to display the current model data
    public void updateView() {
        invokeViewMethod("displayStudent", String.class, String.class, String.class,
                getStudentName(), getStudentId(), getStudentGrade());
    }

    private Object invokeModelMethod(String methodName) {
        try {
            return model.getClass().getMethod(methodName).invoke(model);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke method: " + methodName, e);
        }
    }

    private void invokeModelMethod(String methodName, Class<?> parameterType, Object value) {
        try {
            model.getClass().getMethod(methodName, parameterType).invoke(model, value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke method: " + methodName, e);
        }
    }

    private void invokeViewMethod(String methodName,
                                  Class<?> parameterType1,
                                  Class<?> parameterType2,
                                  Class<?> parameterType3,
                                  Object value1,
                                  Object value2,
                                  Object value3) {
        try {
            view.getClass().getMethod(methodName, parameterType1, parameterType2, parameterType3)
                    .invoke(view, value1, value2, value3);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke method: " + methodName, e);
        }
    }
}
