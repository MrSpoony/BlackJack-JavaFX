package ch.bbcag.cardgames.gui.scenes;


import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import ch.bbcag.cardgames.gui.common.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class BlackjackScene extends BackgroundScene {

    public BlackjackScene(Navigator navigator) {
        super(navigator);
    }

    private final TransparentButton btnSplit = new TransparentButton("Split");
    private final TransparentButton btnDouble = new TransparentButton("Double");
    private final TransparentButton btnHit = new TransparentButton("Hit");
    private final TransparentButton btnHold = new TransparentButton("Hold");
    private final TransparentButton btnHelp = new TransparentButton("Help");

    private final LabelLayout moneyLbl = new LabelLayout("Money:");
    private final LabelLayout subtotalLbl = new LabelLayout("Subtotal:");
    private final LabelLayout moneyInsertLbl = new LabelLayout("Your Insert:");

    private final TextField moneyInsertTxt = new TextField("Enter your Money Insert");

    private final double marginforAnchorPain = 10.0;
    private final double marginForMoneyInserts = 75.0;

    private final double textFieldWidth = 150;
    private final double textFieldHeight = 30;

    private PositionOfLabels positionOfLabels = new PositionOfLabels();
    private PositionOfTextFields positionOfTextFields = new PositionOfTextFields();
    private PositionOfHboxes positionOfHboxes = new PositionOfHboxes();



    @Override
    public void update(double deltaInSec) {

        btnSplit.setOnMouseClicked(mouseEventHandler);
        btnDouble.setOnMouseClicked(mouseEventHandler);
        btnHit.setOnMouseClicked(mouseEventHandler);
        btnHold.setOnMouseClicked(mouseEventHandler);
        btnHelp.setOnMouseClicked(mouseEventHandler);
    }

    @Override
    public void paint() {
        AnchorPane mainAnchorPain = new AnchorPane();
        HBox mainHbox = new HBox();
        HBox hBoxForHelpbtn = new HBox();


        mainAnchorPain.setPrefSize(BaseScene.SCREEN_WIDTH, BaseScene.SCREEN_HEIGHT);
        positionOfLabels.setTopLeftLbl(moneyLbl,marginforAnchorPain);
        positionOfLabels.setBottomLeftLbl(subtotalLbl, marginforAnchorPain);
        positionOfLabels.setBottomRightForSpecials(moneyInsertLbl, 100.0, marginForMoneyInserts);

        positionOfTextFields.setBottomRightForSpecials(moneyInsertTxt, marginForMoneyInserts,50.0);

        moneyInsertTxt.setPrefSize(textFieldWidth, textFieldHeight);

        mainHbox.getChildren().addAll(btnHit, btnHold, btnDouble, btnSplit);
        hBoxForHelpbtn.getChildren().add(btnHelp);

        mainHbox.setSpacing(5);

        mainAnchorPain.getChildren().addAll(moneyLbl, subtotalLbl, moneyInsertTxt,moneyInsertLbl,mainHbox, hBoxForHelpbtn);

        positionOfHboxes.setBottomRightBox(mainHbox,marginforAnchorPain);
        positionOfHboxes.setTopRightBox(hBoxForHelpbtn, marginforAnchorPain);

        getGroup().getChildren().add(mainAnchorPain);
        super.paint();
    }

}