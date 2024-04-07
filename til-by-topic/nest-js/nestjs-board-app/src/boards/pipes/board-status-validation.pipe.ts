import {ArgumentMetadata, BadRequestException, PipeTransform} from "@nestjs/common";
import {BoardStatus} from "../board.model";

export class BoardStatusValidationPipe implements PipeTransform {

  readonly StatusOptions = [
    BoardStatus.PUBLIC,
    BoardStatus.PRIVATE,
  ]

  transform(value: any, metadata: ArgumentMetadata) {
    value = value.toUpperCase();

    if (!this.isStatusValid(value)) {
      throw new BadRequestException(`${value} is an invalid status`);
    }

    return value;
  }

  private isStatusValid(status: any) {
    const idx = this.StatusOptions.indexOf(status);
    return idx !== -1;
  }
}
