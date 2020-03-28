package com.madfeet.sirutest.objects.items;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.stream.Stream;

public class TurtleHat extends BipedModel<LivingEntity> {

    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape6;

    private static final VoxelShape vshape = Stream.of(
            Block.makeCuboidShape(4, 2, 4, 12, 4, 13),
            Block.makeCuboidShape(7, 2, 3, 9, 4, 4),
            Block.makeCuboidShape(7, 9.707106781186548, 9.292893218813452, 8, 12.707106781186548, 10.292893218813452),
            Block.makeCuboidShape(6, 5.38268343236509, 7.923879532511287, 10, 9.38268343236509, 11.923879532511286),
            Block.makeCuboidShape(3, 0, 3, 13, 2, 13),
            Block.makeCuboidShape(5, 2, 5, 11, 6, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public TurtleHat(float size) {
        super(size);
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.shape1 = new ModelRenderer(this, 0, 0);
        //this.shape1.setRotationPoint(-4.0F, -8.0F, 4.0F);
        this.shape1.addBox(4, 2, 4, 12, 4, 13, size);

        this.shape2 = new ModelRenderer(this);
        //this.shape2.setRotationPoint(-4.0F, -8.5F, -4.0F);
        this.shape2.addBox(7, 2, 3, 9, 4, 4, size);

        this.shape3 = new ModelRenderer(this);
        //this.shape3.setRotationPoint(4.0F, -8.0F, -4.0F);
        this.shape3.addBox(7, 9.707106781186548f, 9.292893218813452f, 8, 12.707106781186548f, 10.292893218813452f, size);

        this.shape4 = new ModelRenderer(this);
        //this.shape4.setRotationPoint(-4.5F, -8.0F, -4.0F);
        this.shape4.addBox(6, 5.38268343236509f, 7.923879532511287f, 10, 9.38268343236509f, 11.923879532511286f, size);

        this.shape5 = new ModelRenderer(this);
        //this.shape5.setRotationPoint(-4.5F, -8.0F, -4.0F);
        this.shape5.addBox(3, 0, 3, 13, 2, 13, size);

        this.shape6 = new ModelRenderer(this);
        //this.shape6.setRotationPoint(-4.5F, -8.0F, -4.0F);
        this.shape6.addBox(5, 2, 5, 11, 6, 12, size);

        //this.bipedHead.addChild(new ModelRenderer(t));

        //this.bipedHead.addChild((ModelRenderer) );

        this.bipedHead.addChild(shape1);
        this.bipedHead.addChild(shape2);
        this.bipedHead.addChild(shape3);
        this.bipedHead.addChild(shape4);
        this.bipedHead.addChild(shape5);
        this.bipedHead.addChild(shape6);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
        super.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
