package ch.bbcag.cardgames.gui.scenes;


import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import ch.bbcag.cardgames.gui.common.LabelLayout;
import ch.bbcag.cardgames.gui.common.TransparentButton;
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

    private final LabelLayout moneyLbl = new LabelLayout("Money:");
    private final LabelLayout subtotalLbl = new LabelLayout("Subtotal:");
    private final LabelLayout moneyInsertLbl = new LabelLayout("Your Insert:");

    private final TextField moneyInsertTxt = new TextField("Enter your Money Insert");

    private final double marginforAnchorPain = 10.0;
    private final double marginForMoneyInserts = 75.0;



    @Override
    public void update(double deltaInSec) {

        btnSplit.setOnMouseClicked(mouseEventHandler);
        btnDouble.setOnMouseClicked(mouseEventHandler);
        btnHit.setOnMouseClicked(mouseEventHandler);
        btnHold.setOnMouseClicked(mouseEventHandler);
    }

    @Override
    public void paint() {
        AnchorPane mainAnchorPain = new AnchorPane();
        HBox mainHbox = new HBox();


        mainAnchorPain.setPrefSize(BaseScene.SCREEN_WIDTH, BaseScene.SCREEN_HEIGHT);
        AnchorPane.setTopAnchor(moneyLbl, marginforAnchorPain);
        AnchorPane.setBottomAnchor(subtotalLbl, marginforAnchorPain);
        AnchorPane.setBottomAnchor(moneyInsertTxt, 50.0);
        AnchorPane.setRightAnchor(moneyInsertTxt, marginForMoneyInserts);
        AnchorPane.setBottomAnchor(moneyInsertLbl,marginForMoneyInserts);
        AnchorPane.setRightAnchor(moneyInsertLbl, 95.0);

        mainHbox.getChildren().addAll(btnHit, btnHold, btnDouble, btnSplit);

        mainHbox.setSpacing(5);

        mainAnchorPain.getChildren().addAll(moneyLbl, subtotalLbl, moneyInsertTxt,moneyInsertLbl,mainHbox);



        AnchorPane.setRightAnchor(mainHbox, marginforAnchorPain);
        AnchorPane.setBottomAnchor(mainHbox, marginforAnchorPain);


        getGroup().getChildren().add(mainAnchorPain);
        super.paint();
    }

}