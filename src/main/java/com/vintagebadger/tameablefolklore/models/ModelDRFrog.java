package com.vintagebadger.tameablefolklore.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import net.ilexiconn.llibrary.LLibrary;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;



/**
 * DRFrog - VintageBadger
 * Created using Tabula 7.0.0
 */
public class ModelDRFrog extends AdvancedModelBase {
    public AdvancedModelRenderer body;
    public AdvancedModelRenderer armRight;
    public AdvancedModelRenderer armLeft;
    public AdvancedModelRenderer legRight;
    public AdvancedModelRenderer legLeft;
    public AdvancedModelRenderer head;
    public AdvancedModelRenderer eyeLeft;
    public AdvancedModelRenderer eyeRight;

    public ModelDRFrog() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.eyeLeft = new AdvancedModelRenderer(this, 0, 0);
        this.eyeLeft.setRotationPoint(-1.6F, -1.0F, -1.5F);
        this.eyeLeft.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.legRight = new AdvancedModelRenderer(this, 0, 0);
        this.legRight.setRotationPoint(3.0F, 1.6F, 3.4F);
        this.legRight.addBox(0.0F, -0.2F, 0.0F, 1, 1, -4, 0.0F);
        this.setRotateAngle(legRight, 0.3141592653589793F, 0.0F, 0.0F);
        this.legLeft = new AdvancedModelRenderer(this, 0, 0);
        this.legLeft.setRotationPoint(-3.1F, 1.7F, 3.2F);
        this.legLeft.addBox(-0.9F, -0.2F, 0.0F, 1, 1, -4, 0.0F);
        this.setRotateAngle(legLeft, 0.3141592653589793F, 0.0F, 0.0F);
        this.head = new AdvancedModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -0.7F, -2.1F);
        this.head.addBox(-2.0F, -1.6F, -2.3F, 4, 3, 2, 0.0F);
        this.body = new AdvancedModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.1F, 20.0F, 0.0F);
        this.body.addBox(-3.0F, -2.0F, -3.5F, 6, 4, 7, 0.0F);
        this.setRotateAngle(body, -0.2617993877991494F, 0.0F, 0.0F);
        this.armRight = new AdvancedModelRenderer(this, 0, 0);
        this.armRight.setRotationPoint(3.0F, 0.0F, -2.5F);
        this.armRight.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.armLeft = new AdvancedModelRenderer(this, 0, 0);
        this.armLeft.setRotationPoint(-4.0F, 0.0F, -2.5F);
        this.armLeft.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.eyeRight = new AdvancedModelRenderer(this, 0, 0);
        this.eyeRight.setRotationPoint(1.6F, -1.0F, -1.5F);
        this.eyeRight.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.head.addChild(this.eyeLeft);
        this.body.addChild(this.legRight);
        this.body.addChild(this.legLeft);
        this.body.addChild(this.head);
        this.body.addChild(this.armRight);
        this.body.addChild(this.armLeft);
        this.head.addChild(this.eyeRight);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
