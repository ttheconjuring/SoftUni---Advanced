package JAVA_OOP.S_O_L_I_D_Lab.p01_SingleResponsibility.p01_DrawingShape;

import JAVA_OOP.S_O_L_I_D_Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import JAVA_OOP.S_O_L_I_D_Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import JAVA_OOP.S_O_L_I_D_Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;
import JAVA_OOP.S_O_L_I_D_Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Rengerer;

public class DrawingManagerImpl implements DrawingManager {

    private final DrawingRepository drawingRepository;
    private final Rengerer renderer;

    public DrawingManagerImpl(DrawingRepository drawingRepository, Rengerer renderer) {
        this.drawingRepository = drawingRepository;
        this.renderer = renderer;
    }

    @Override
    public void draw(Shape shape) {
        shape.draw(this.renderer, this.drawingRepository);
    }
}
